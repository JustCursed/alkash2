package com.example.vtbmap


data class Atm(
    val address: String? = null,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val allDay: Boolean = false,
    var wheelchairCapability: Boolean = false,
    var wheelchairActivity: Boolean = false,
    var blindCapability: Boolean = false,
    var blindActivity: Boolean = false,
    var nfcForBankCardsCapability: Boolean = false,
    var nfcForBankCardActivity: Boolean = false,
    var qrReadCapability: Boolean = false,
    var qrReadActivity: Boolean = false,
    var supportUsdCapability: Boolean = false,
    var supportUsdActivity: Boolean = false,
    var supportsChargeRubCapability: Boolean = false,
    var supportChargeRubActivity: Boolean = false,
    var supportsEurCapability: Boolean = false,
    var supportEurActivity: Boolean = false,
    var supportsRubCapability: Boolean = false,
    var supportRubActivity: Boolean = false,
)
