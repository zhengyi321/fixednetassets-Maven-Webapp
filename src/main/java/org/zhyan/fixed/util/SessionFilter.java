/**
 *
 * @author geloin
 * @date 2012-4-10 下午2:37:38
 */
package org.zhyan.fixed.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登录过滤
 * 
 */
public class SessionFilter extends OncePerRequestFilter {

	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 不过滤的uri
		//String[] notFilter = new String[] { "login.jsp", "index.html" };
		
		String str = request.getParameter("key");
		String requestUrl=request.getRequestURI();
		System.out.println("请求路径-----"+requestUrl);
		if( !(null==requestUrl||"".equals(requestUrl))&& requestUrl.contains("/mobile")){//手机请求
			
				//校验通过 正群的非伪造的的手机请求
				System.out.println("手机请求过来!-----放行!");
			filterChain.doFilter(request, response);
			
			
		} else {//其他请求
			
			System.out.println("PC请求过来!-----放行!");
			String uri = request.getRequestURI();
			System.out.println(uri);
			if (uri.indexOf(".do") > 0 ){
				if(uri.indexOf("login.do") == -1){
					Object obj = request.getSession().getAttribute("username");
					if (null == obj) {
						// 如果session中不存在登录者实体，则弹出框提示重新登录
						// 设置request和response的字符集，防止乱码
						request.setCharacterEncoding("UTF-8");
						response.setCharacterEncoding("UTF-8");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						//response.sendRedirect("/login.jsp");
					} else {
						// 如果session中存在登录者实体，则继续
						filterChain.doFilter(request, response);
					}
				}else{
					filterChain.doFilter(request, response);
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}
		
	}

}
