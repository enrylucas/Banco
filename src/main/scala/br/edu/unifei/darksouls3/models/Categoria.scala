package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._

  object Categoria extends Enumeration {
    type Categoria = Value
    val adaga = Value("Adaga")
    val espada = Value("Espada")
    val katana = Value("Katana")
    val machado = Value("Machado")
    val elmo = Value("Elmo")
    val armadura = Value("Armadura")
    val calca = Value("Calça")
    val botas = Value("Botas")

    implicit val enumMapper = MappedColumnType.base[Categoria, String](_.toString, this.withName)
  }
