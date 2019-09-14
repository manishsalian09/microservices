package org.trident.designer.service;

import org.trident.designer.dto.ProcessDTO;

public interface ProcessService {
	
	ProcessDTO findByProcessId(final Long processId);
	ProcessDTO createProcess(final ProcessDTO processDTO);
	ProcessDTO modifyProcess(final ProcessDTO processDTO);
	void deleteProcess(final ProcessDTO processDTO);

}
