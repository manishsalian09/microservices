package org.trident.designer.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trident.designer.dto.ActivityDTO;
import org.trident.designer.dto.AssociationDTO;
import org.trident.designer.dto.ProcessDTO;
import org.trident.designer.exception.ValidationException;
import org.trident.designer.service.ProcessService;

@RestController
@RequestMapping("processes")
public class ProcessController {
	
	@Autowired
	private ProcessService processService;

	@PostMapping
	public ResponseEntity<?> createProcess(@Valid @RequestBody ProcessDTO processDTO,
			Errors errors) throws URISyntaxException {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		final Long processId = processService.createProcess(processDTO).getProcessId();
		final URI location = new URI("/processes/" + processId);
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> modifyProcess(@Valid @RequestBody ProcessDTO processDTO,
			Errors errors) {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		final ProcessDTO response = processService.modifyProcess(processDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("{processId}")
	public ResponseEntity<?> deleteProcess(@PathVariable("processId") Long processId) {
		final ProcessDTO processDTO = processService.findByProcessId(processId);
		processService.deleteProcess(processDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{processId}")
	public ResponseEntity<?> findByProcessId(@PathVariable("processId") Long processId) {
		final ProcessDTO processDTO = processService.findByProcessId(processId);
		return ResponseEntity.status(HttpStatus.OK).body(processDTO);
	}

	@PostMapping("{processId}/activities")
	public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityDTO activityDTO, Errors errors) {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
	}

	@PutMapping("{processId}/activities")
	public ResponseEntity<?> modifyActivity(@Valid @RequestBody ActivityDTO activityDTO, Errors errors) {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		return ResponseEntity.status(HttpStatus.OK).body(activityDTO);
	}

	@DeleteMapping("{processId}/activities/{activityId}")
	public ResponseEntity<?> deleteActivity(@PathVariable("processId") Long processId,
			@PathVariable("activityId") Long activityId) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@GetMapping("{processId}/activities/{activityId}")
	public ResponseEntity<?> findActivityByActivityId(@PathVariable("processId") Long processId,
			@PathVariable("activityId") Long activityId) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping("{processId}/activities/{activityId}/associations")
	public ResponseEntity<?> createAssociation(@Valid @RequestBody AssociationDTO associationDTO, Errors errors) {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		return ResponseEntity.status(HttpStatus.OK).body(associationDTO);
	}

	@PutMapping("{processId}/activities/{activityId}/associations")
	public ResponseEntity<?> modifyAssociation(@Valid @RequestBody AssociationDTO associationDTO, Errors errors) {
		if (errors.hasErrors()) throw new ValidationException("Field Validation Errors", errors);
		return ResponseEntity.status(HttpStatus.OK).body(associationDTO);
	}

	@DeleteMapping("{processId}/activities/{activityId}/associations/{associationId}")
	public ResponseEntity<?> deleteAssociation(@PathVariable("processId") Long processId,
			@PathVariable("activityId") Long activityId, @PathVariable("associationId") Long associationId) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@GetMapping("{processId}/activities/{activityId}/associations/{associationId}")
	public ResponseEntity<?> findAssociationByAssociationId(@PathVariable("processId") Long processId,
			@PathVariable("activityId") Long activityId, @PathVariable("associationId") Long associationId) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
