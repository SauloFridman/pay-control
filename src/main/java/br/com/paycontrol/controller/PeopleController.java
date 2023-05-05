package br.com.paycontrol.controller;

import br.com.paycontrol.data.vo.v1.V1_People;
import br.com.paycontrol.model.FinanceDepartment;
import br.com.paycontrol.model.People;
import br.com.paycontrol.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/people")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PeopleController {
    @Autowired
    PeopleService peopleService;


    @GetMapping(value = "/{id}",
            produces = {MEDIATYPE_JSON,MEDIATYPE_YAML,MEDIATYPE_XML})
    @Operation(summary = "Find a People", description = "Find a People",
            tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = People.class))}),
            @ApiResponse(description = "No Content",responseCode = "204",content = @Content),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_People findById(@PathVariable(value = "id") Long id){
        return peopleService.findById(id);
    }

    @GetMapping(value = "/all",
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Find a People", description = "Find a People",
            tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = People.class))}),
            @ApiResponse(description = "No Content",responseCode = "204",content = @Content),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public List<V1_People> findByAll(){
        return peopleService.findByAll();
    }

    @PostMapping(value = "/add", consumes = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML},
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Adds a new People", description = "Add new register a People by passing in Json, XML or YAML representention of FinanceDepartment",
            tags = {"FinanceDepartment"}, responses = {@ApiResponse(description = "Add", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = People.class))}),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_People create(@RequestBody @Valid V1_People v1People){
        return peopleService.create(v1People);
    }


    @PutMapping(value = "/update", consumes = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML},
            produces = {MEDIATYPE_YAML,MEDIATYPE_JSON,MEDIATYPE_XML})
    @Operation(summary = "Update a People", description = "Update a register FinanceDepartment by passing in Json, XML or YAML representention of People",
            tags = {"People"}, responses = {@ApiResponse(description = "Updated", responseCode = "200",
            content = {@Content( mediaType = "application/json, application/xml, application/x-yaml",
                    schema = @Schema(implementation = People.class))}),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public V1_People upDate(@RequestBody @Valid V1_People v1People){
        return peopleService.upDate(v1People);
    }

    @DeleteMapping(value = "/delete")
    @Operation(summary = "Delete a People", description = "Deleted a register People by passing in Json, XML or YAML representention of People",
            tags = {"People"}, responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request",responseCode = "400",content = @Content),
            @ApiResponse(description = "Unauthorized",responseCode = "401",content = @Content),
            @ApiResponse(description = "Not Found",responseCode = "404",content = @Content),
            @ApiResponse(description = "Internal Server Error",responseCode = "500",content = @Content)})
    public ResponseEntity<?> delete(Long id){
        peopleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}