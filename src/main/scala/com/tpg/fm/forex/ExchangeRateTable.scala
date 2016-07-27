package com.tpg.fm.forex

import com.tpg.fm.core.Money
import com.tpg.fm.forex.ExchangeRate.CurrencyPair

case class ExchangeRateTable(ratesByCurrencyPair: Map[ExchangeRate.CurrencyPair, ExchangeRate]) {
  def apply(key: CurrencyPair): Option[ExchangeRate] = ratesByCurrencyPair.get(key)
}

object ExchangeRateTable {
  def apply(rates: Seq[ExchangeRate]): ExchangeRateTable = {
    val normalRates = rates map { rate => (rate.X, rate.Y) -> rate }
    val inverseRates = rates map { rate => (rate.Y, rate.X) -> ExchangeRate(rate.Y, rate.X, Money.One / rate.price, rate.t) }

    val allRates = normalRates ++ inverseRates
    new ExchangeRateTable(allRates toMap)
  }
}
