package com.example.demogroup.service;

public interface QrCodeService {

    byte[] generateQRCode(String qrContent, int width, int height);

}
