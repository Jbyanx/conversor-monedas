package dto;

public record ApiResponse(
        String result,
        String base_code,
        String target_code,
        String conversion_rate,
        String conversion_result
) {
}
