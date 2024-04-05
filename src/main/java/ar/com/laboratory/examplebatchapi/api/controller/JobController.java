package ar.com.laboratory.examplebatchapi.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

public interface JobController {
    @Tag(name = "Example Batch API", description = "This is an example of an API that runs a batch process")
    public interface ProductController {

        @ApiResponse(
                responseCode = "400",
                description = "When the request have a field invalid we response this",
                content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class))
                }
        )
        @Operation(summary = "Return a list with Products")
        public ResponseEntity<String> runJob();

    }

}
