package com.xmg.crm.page;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class PageResult {
	private Long total;
	private List rows;
	public static final PageResult EMPTY =new PageResult(0L,Collections.EMPTY_LIST);
	
	public PageResult(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public PageResult() {
		super();
	}
}
