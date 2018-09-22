package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

  object Categoria extends Enumeration {
    type Categoria = Value
    val adaga = Value("adaga string")
    val espada = Value("espada")
    val katana = Value("katana")

    implicit val enumMapper = MappedColumnType.base[Categoria, String](_.toString, this.withName)
  }
