package com.tpg.fm.forex

import com.tpg.fm.core.Money.One
import com.tpg.fm.core.{GBP, USD}
import org.joda.time.DateTime
import org.scalatest.{FlatSpec, Matchers}

class ExchangeRateTableSpec extends FlatSpec with Matchers {
  val now = new DateTime()

  "exchange rates" should "exchange rates and their inverses" in {
    val rate1 = ExchangeRate(USD, GBP, BigDecimal("0.6238"), now)

    val rate2 = ExchangeRate(GBP, USD, One / BigDecimal("0.6238"), now)

    val actual = ExchangeRateTable(Seq(rate1))

    actual(USD, GBP).get should be(rate1)
    actual(GBP, USD).get should be(rate2)
  }
}
