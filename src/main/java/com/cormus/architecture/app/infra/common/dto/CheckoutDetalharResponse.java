package com.cormus.architecture.app.infra.common.dto;

public record CheckoutDetalharResponse(
        Long idPedido,
        String linkQrCode
) {
}
