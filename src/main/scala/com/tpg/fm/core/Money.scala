package com.tpg.fm.core

import com.tpg.fm.asset.{Y, X}
import org.joda.time.DateTime

case class Money(currency: Currency, amount: BigDecimal, t: DateTime = new DateTime()) extends X with Y {
  override def X = this
  override def Y = this
}

object Money {
  val One = BigDecimal("1.000000")
}
