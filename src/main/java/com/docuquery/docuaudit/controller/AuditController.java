package com.docuquery.docuaudit.controller;

import com.docuquery.docuaudit.model.AuditLog;
import com.docuquery.docuaudit.repository.AuditLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private final AuditLogRepository repository;

    public AuditController(AuditLogRepository repository) {
        this.repository = repository;
    }

    // GET: http://localhost:8080/api/audit
    @GetMapping
    public List<AuditLog> getAllAudits() {
        return repository.findAll();
    }

    // POST: http://localhost:8080/api/audit
    @PostMapping
    public AuditLog createAudit(@RequestBody AuditLog auditLog) {
        return repository.save(auditLog);
    }
}