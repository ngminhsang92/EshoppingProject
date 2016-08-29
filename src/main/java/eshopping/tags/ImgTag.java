package eshopping.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

public class ImgTag extends SimpleTagSupport {

	private String id;

	private String height;

	private String width;

	private String cssClass;

	private Blob blob;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (id == null || blob == null) {
			return;
		}
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id + ".png");
		File img = new File(path.toString());

		if (!img.exists()) {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(img);
				fileOutputStream.write(blob.getBytes(1L, (int) blob.length()));
				fileOutputStream.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		String style = "";
		if (height != null) {
			style += "height:" + height + "; ";
		}

		if (width != null) {
			style += "width:" + width;
		} else {
			style += "width:100%";
		}

		
		getJspContext().getOut()
				.write("<img src='" + request.getContextPath() + "/resources/images/" + id + ".png' alt='image' class='"+cssClass+ "' style='"+style+"' />");
	}

}
