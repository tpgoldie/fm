package com.tpg.fm.forex

import com.tpg.fm.core.{EURO, Money, USD}
import org.joda.time.DateTime
import org.scalatest.{Matchers, FlatSpec}

class ExchangeRateSpec extends FlatSpec with Matchers {
  "exchange rate" should "have an inverse rate" in {
    val now = new DateTime()

    val rate = ExchangeRate(Money(EURO, BigDecimal("1.0000"), now), Money(USD, BigDecimal("1.0000"), now),
      BigDecimal("1.4415"), now)

    val actual = rate.inverse

    actual should have(
      'X(Money(USD, BigDecimal("1.0000"), now)),
      'Y(Money(EURO, BigDecimal("1.0000"), now)),
      't(now)
    )

    actual.price should be(BigDecimal("0.6937") +- 1e-4)
  }
}
