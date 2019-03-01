package com.vignet.dao;

import com.vignet.bo.VisitorsBO;
import com.vignet.dto.VisitorsDTO;

public interface VisitorsDAO {

	public int insert(VisitorsBO bo);

	public int select(VisitorsBO bo);
}