package com.cormus.architecture.app.domain.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutDTO {
    public Long idPedido;
    public String qrCodeUrl;
}
