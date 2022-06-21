package tw.com.westeros.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
@WebFilter("/*") // 對於所有請求進行攔截
public class LoginFilter implements Filter {
	
	// 預設排除重導行為的頁面
	final private String EXCLUDED_PAGES = "index.jsp,login.jsp,message.jsp,Login.do,basicStyle.css";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// 強制轉型，取得 http 的 request&response，才可使用 http 相關的方法
		// 在 ServletRequest 中沒有 getSession 方法
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		// 實現頁面排除
		String[] excludedPageAL = EXCLUDED_PAGES.split(",");
		String requestPath = httpRequest.getServletPath();
		Boolean shouldWeRedirect = true;  // false-不要重導頁面
		
		for (String s : excludedPageAL) {
			// 如果請求的資源路徑，在排除重導頁面陣列之中的話，則不進行頁面重導
			if (requestPath.contains(s)) {
				shouldWeRedirect = false;
				break;
			}
		}
		
		// 如果使用者沒有登入 且此資源應該被重導(此資源受保護)，則進行頁面重導
		// 調派請求中只有相對路徑寫法
		if (session.getAttribute("user") == null && shouldWeRedirect == true) {
			session.setAttribute("message", "此頁面需登入後才可瀏覽！三秒後重新導向登入頁面...");
			session.setAttribute("redirectPage","login.jsp");
			httpResponse.sendRedirect("/IceAndFire/page/message.jsp");
		}
		
 		// Filter 還可以用於流量統計、點擊次數統計...etc.
		
		chain.doFilter(request, response);
	}

}
**/