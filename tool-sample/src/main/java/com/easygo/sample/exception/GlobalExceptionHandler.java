package com.easygo.sample.exception;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.easygo.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;

/**
 * 异常处理器
 *
 * @Author scott
 * @Date 2019
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(BusinessException.class)
	public Result<?> handleRRException(BusinessException e) {
		log.error(e.getMessage(), e);
		Integer code = e.getCode();
		if (null == code){
			return Result.error(e.getMessage());
		}
		return Result.error(e.getCode(),e.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public Result<?> handlerNoFoundException(Exception e) {
		log.error(e.getMessage(), e);
		return Result.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result<?> handleDuplicateKeyException(DuplicateKeyException e) {
		log.error(e.getMessage(), e);
		return Result.error("数据库中已存在该记录");
	}



	@ExceptionHandler(Exception.class)
	public Result<?> handleException(Exception e) {
		log.error(e.getMessage(), e);
		return Result.error("操作失败!");
	}

	/**
	 * @param e
	 * @return
	 * @Author 政辉
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("不支持");
		sb.append(e.getMethod());
		sb.append("请求方法，");
		sb.append("支持以下");
		String[] methods = e.getSupportedMethods();
		if (methods != null) {
			for (String str : methods) {
				sb.append(str);
				sb.append("、");
			}
		}
		log.error(sb.toString(), e);
		//return Result.error("没有权限，请联系管理员授权");
		return Result.error(405, sb.toString());
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Result<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		log.error(e.getMessage(), e);
		return Result.error(e.getMessage());
	}

	/**
	 * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public Result<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
		log.error(e.getMessage(), e);
		return Result.error("文件大小超出10MB限制, 请压缩或降低文件质量! ");
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public Result<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		log.error(e.getMessage(), e);
		return Result.error();
	}

	@ExceptionHandler(PoolException.class)
	public Result<?> handlePoolException(PoolException e) {
		log.error(e.getMessage(), e);
		return Result.error("Redis 连接异常!");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Result<?> handleException(HttpServletRequest request, MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		String errorMessage = "";
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errorMessage += fieldError.getField() + fieldError.getDefaultMessage() + ",";
		}
		String finalErrorMessage = errorMessage.substring(0, errorMessage.length() - 1);
		String url = request.getRequestURL().toString();
		log.error("find exception:url={}, e={}", url, e);

		return Result.error(finalErrorMessage);
	}

	@ExceptionHandler(SQLException.class)
	public Result<?> handleSQLException(SQLException e) {
		String message = e.getMessage();
		log.error(message, e);
		return Result.error(message);
	}

	@ExceptionHandler(MybatisPlusException.class)
	public Result<?> handleMybatisPlusException(MybatisPlusException e) {
		String message = e.getMessage();
		log.error(message, e);
		return Result.error(message);

	}
	@ExceptionHandler(PersistenceException.class)
	public Result<?> handlePersistenceException(PersistenceException e) {
		String message = e.getMessage();
		log.error(message, e);
		return Result.error(message);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public Result<?> handleConstraintViolationException(ConstraintViolationException e) {
		String message = e.getMessage();
		log.error(message, e);
		return Result.error(message);

	}
}
