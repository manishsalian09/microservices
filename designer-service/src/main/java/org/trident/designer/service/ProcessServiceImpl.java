package org.trident.designer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trident.designer.dto.ProcessDTO;
import org.trident.designer.entity.Process;
import org.trident.designer.exception.ValidationException;
import org.trident.designer.repository.ProcessRepository;

import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {

    private ProcessRepository processRepository;

    @Autowired
    public ProcessServiceImpl(final ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Override
    public ProcessDTO findByProcessId(final Long processId) {
        Optional<Process> process = this.processRepository.findById(processId);
        if (process.isEmpty()) throw new ValidationException("Process does not exist", null);
        return process.get().toDto();
    }

    @Override
    public ProcessDTO createProcess(final ProcessDTO processDTO) {
        Process process = processDTO.toEntity();
        process = this.processRepository.save(process);
        return process.toDto();
    }

    @Override
    public ProcessDTO modifyProcess(final ProcessDTO processDTO) {
        Process process = processDTO.toEntity();
        process = this.processRepository.save(process);
        return process.toDto();
    }

    @Override
    public void deleteProcess(final ProcessDTO processDTO) {
        Process process = processDTO.toEntity();
        this.processRepository.save(process);
    }
}
