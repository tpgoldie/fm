package com.tpg.fm.core

import com.tpg.fm.asset.{Asset, X, Y}

sealed abstract class UnitsOf[T <: Asset](quantity: BigDecimal, asset: T)

case class UnitsOfX(quantity: BigDecimal, asset: X) extends UnitsOf[X](quantity, asset)

case class UnitsOfY(quantity: BigDecimal, asset: Y) extends UnitsOf[Y](quantity, asset)
