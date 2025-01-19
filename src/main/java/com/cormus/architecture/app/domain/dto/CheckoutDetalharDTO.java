package com.cormus.architecture.app.domain.dto;

public record CheckoutDetalharDTO(
        Long idPedido,
        String linkQrCode
) {
}
