package com.cormus.architecture.app.infra.common.dto;

public record CheckoutDetalharDTO(
        Long idPedido,
        String linkQrCode
) {
}
