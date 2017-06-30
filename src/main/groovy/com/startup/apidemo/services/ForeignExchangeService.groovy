package com.startup.apidemo.services

import org.springframework.stereotype.Service
import groovy.json.JsonOutput
/**
 * Created by dxl0190 on 6/29/17.
 */
@Service
class ForeignExchangeService {

    private static final String APP_ID = 'df12e49e55a34cf0927f592c2a36f8b0'

    def getCurrency(def currency) {
        String baseURL = "https://openexchangerates.org/api/latest.json?" +
                "app_id=$APP_ID&base=$currency"

        String json = "$baseURL".toURL().text
        return JsonOutput.prettyPrint(json)
    }

    def getConversion(int value, def fromCurrency, def toCurrency) {
        String baseURL = 'https://openexchangerates.org/api/convert/'
        def queryString = "$value/$fromCurrency/$toCurrency?app_id=$APP_ID"
        String json = "$baseURL$queryString".toURL().text

        return json
    }
}
