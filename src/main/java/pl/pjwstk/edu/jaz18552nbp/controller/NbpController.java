package pl.pjwstk.edu.jaz18552nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pjwstk.edu.jaz18552nbp.model.Result;
import pl.pjwstk.edu.jaz18552nbp.service.NbpService;

@RestController
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation(value = "Get gold pirce", notes = "calculate gold by provided data")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Successfully query execution"),
            @ApiResponse(code = 404, message ="no data for the query" ),
            @ApiResponse(code = 400, message ="incorrectly formed query" )
    })
    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<Result> getAvgPriceGold(
            @ApiParam(value = "beginning of time period") @PathVariable String startDate,
            @ApiParam(value = "end of time period") @PathVariable String endDate) {
        return ResponseEntity.ok(nbpService.getGoldByProvidedData(startDate,endDate));
    }
}
