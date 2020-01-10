package com.goodlife.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


public final class RestApiUtils {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestApiUtils.class);

	private final static String PARAM_SIG = "signature";

	/**
	 * push request params key-value to map, the values are all url decoded
	 * 
	 * @param request
	 * @return
	 */
	public final static Map<String, String> getRequestParamMap(HttpServletRequest request) {
		Map<String, String> requestParamsMap = new HashMap<String, String>(5);
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String param = e.nextElement();
			String value = request.getParameter(param);
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("getRequestParamMap(HttpServletRequest) - [%s=>%s]", param, value));
			}

			if (value != null) {
				requestParamsMap.put(param, value);
			}
		}
		return requestParamsMap;
	}

	/**
	 * 对http请求参数作字典排序，拼接字符串
	 * 
	 * @param paramMap
	 * @param sigParamKey
	 * @return
	 */
	public final static String generateNormalizedString(Map<String, String> paramMap, String sigParamKey) {
		Set<String> params = paramMap.keySet();
		List<String> sortedParams = new ArrayList<String>(params);
		Collections.sort(sortedParams);
		List<String> arr = new ArrayList<String>();
		for (String paramKey : sortedParams) {
			StringBuilder sb = new StringBuilder();
			if (paramKey.equals(sigParamKey)) {
				continue;
			}
			sb.append(paramKey).append('=').append(paramMap.get(paramKey));
			arr.add(sb.toString());
		}
		return StringUtils.join(arr, '&');
	}

	/**
	 * 对http请求参数作字典排序，拼接字符串
	 * 
	 * @param request
	 * @return
	 */
	public static String generateNormalizedString(HttpServletRequest request) {
		Map<String, String> requestParamMap = getRequestParamMap(request);
		return RestApiUtils.generateNormalizedString(requestParamMap, PARAM_SIG);
	}
}
