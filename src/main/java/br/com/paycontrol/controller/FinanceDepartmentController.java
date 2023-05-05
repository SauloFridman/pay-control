package br.com.paycontrol.controller;

import br.com.paycontrol.data.vo.v1.V1_FinanceDepartment;
import br.com.paycontrol.model.FinanceDepartment;
import br.com.paycontrol.service.FinanceDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.paycontrol.util.MediaType.*;

@RestController
@RequestMapping("/api/financedepartment")
@Tag(name = "FinanceDepartmentService", description = "Endpoints for Managing FinanceDepartmentService")
public class FinanceDepartmentController {
    @Autowired
    FinanceDepartmentService financeDepartmentService;


    @GetMapping(value = "/{registered}",
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Find a FinanceDepartment", description = "Find a FinanceDepartment",
            tags = {"FinanceDepartment"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = FinanceDepartment.class))}),
            @ApiResponse(description = "No Content",responseCode = "204",content = @Content),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_FinanceDepartment findById(@PathVariable(value = "registered") Long registered){
        return financeDepartmentService.findById(registered);
    }

    @GetMapping(value = "/all",consumes = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML},
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Find all FinanceDepartment", description = "Find all FinanceDepartment",
    tags = {"FinanceDepartment"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
    content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
            array = @ArraySchema(schema = @Schema(implementation = FinanceDepartment.class)))}),
    @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
    @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
    @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
    @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public List<V1_FinanceDepartment> findByAll(){
        return financeDepartmentService.findByAll();
    }

    @PostMapping(value = "/add", consumes = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML},
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Adds a new FinanceDepartment", description = "Add new register a FinanceDepartment by passing in Json, XML or YAML representention of FinanceDepartment",
            tags = {"FinanceDepartment"}, responses = {@ApiResponse(description = "Add", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = FinanceDepartment.class))}),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_FinanceDepartment create(@RequestBody @Valid V1_FinanceDepartment v1FinanceDepartment){
        return financeDepartmentService.create(v1FinanceDepartment);
    }

    @PutMapping(value = "/update", consumes = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML},
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Update a FinanceDepartment", description = "Update a register FinanceDepartment by passing in Json, XML or YAML representention of FinanceDepartment",
            tags = {"FinanceDepartment"}, responses = {@ApiResponse(description = "Updated", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = FinanceDepartment.class))}),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_FinanceDepartment upDate(@RequestBody @Valid V1_FinanceDepartment v1FinanceDepartment){
       return financeDepartmentService.upDate(v1FinanceDepartment);
    }

    @DeleteMapping(value = "/delete/{id}")
               @Operation(summary = "Delete a FinanceDepartment", description = "Deleted a register FinanceDepartment by passing in Json, XML or YAML representention of FinanceDepartment",
            tags = {"FinanceDepartment"}, responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        financeDepartmentService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
