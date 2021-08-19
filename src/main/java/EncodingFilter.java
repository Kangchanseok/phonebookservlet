import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EncodingFilter::init");

	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter::doChain Begin");
		
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		chain.doFilter(req, resp);
		
		System.out.println("EncodingFilter::doChain End");
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter::destroy");

	}

}