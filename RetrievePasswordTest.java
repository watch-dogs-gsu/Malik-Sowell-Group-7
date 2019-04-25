import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

class RetrievePasswordTest {

//	//@Test
//	void testRetrievePassword() {
//		fail("Not yet implemented");
//	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		HttpServletRequest request = new HttpServletRequest() {
			
			public String a0;
			public Object a1 = "test";
			
			@Override
			public AsyncContext getAsyncContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getAttribute(String arg0) {
				// TODO Auto-generated method stub
				return (String) a1;
			}

			@Override
			public Enumeration<String> getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getContentLength() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getContentLengthLong() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public DispatcherType getDispatcherType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ServletInputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLocalAddr() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLocalName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getLocalPort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<Locale> getLocales() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getParameter(String arg0) {
				// TODO Auto-generated method stub
				
				return "correct";
			}

			@Override
			public Map<String, String[]> getParameterMap() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String[] getParameterValues(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getProtocol() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public BufferedReader getReader() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRealPath(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRemoteAddr() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRemoteHost() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getRemotePort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public RequestDispatcher getRequestDispatcher(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getScheme() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getServerName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getServerPort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isAsyncStarted() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isAsyncSupported() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeAttribute(String arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setAttribute(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				
				
				this.a0=arg0;
				System.out.println("This is arg1" + (String) arg1);
				this.a1 = arg1;
				
				
			}

			@Override
			public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public AsyncContext startAsync() throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean authenticate(HttpServletResponse arg0) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String changeSessionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getAuthType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContextPath() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Cookie[] getCookies() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getDateHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getHeader(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getHeaders(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getIntHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getMethod() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Part getPart(String arg0) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<Part> getParts() throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPathInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPathTranslated() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getQueryString() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRemoteUser() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRequestURI() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public StringBuffer getRequestURL() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRequestedSessionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getServletPath() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HttpSession getSession() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HttpSession getSession(boolean arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Principal getUserPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isRequestedSessionIdFromCookie() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromURL() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromUrl() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isUserInRole(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void login(String arg0, String arg1) throws ServletException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void logout() throws ServletException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public <T extends HttpUpgradeHandler> T upgrade(Class<T> arg0) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		HttpServletResponse response = new HttpServletResponse() {
			
			@Override
			public void setLocale(Locale arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentType(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentLengthLong(long arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentLength(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCharacterEncoding(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBufferSize(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void resetBuffer() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public PrintWriter getWriter() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ServletOutputStream getOutputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void flushBuffer() throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStatus(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStatus(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendRedirect(String arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendError(int arg0, String arg1) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendError(int arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getStatus() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Collection<String> getHeaders(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getHeader(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeRedirectUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeRedirectURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsHeader(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void addIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addCookie(Cookie arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		RetrievePassword test= new RetrievePassword();
		test.doGet(request, response);
		String ans = (String) request.getAttribute("myPword");
		System.out.println(ans);
		assertEquals("test", ans );
	}

	//@Test
	//void testDoPostHttpServletRequestHttpServletResponse() {
		//fail("Not yet implemented");
	//}

}
