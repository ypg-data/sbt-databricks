package sbtdatabricks.util

sealed trait DBCExecutionLanguage { val is: String }
case object DBCScala extends DBCExecutionLanguage { override val is = "scala" }
case object DBCPython extends DBCExecutionLanguage { override val is = "python" }
case object DBCSQL extends DBCExecutionLanguage { override val is = "sql" }
