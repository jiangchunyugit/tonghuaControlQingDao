package cn.tonghua.core.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class IntegerEditor extends PropertyEditorSupport {
    @Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals(""))
			text = "0";
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(Integer.parseInt(text));
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}