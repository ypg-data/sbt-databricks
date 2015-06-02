package sbtdatabricks.util

sealed trait DBCExecutionLanguage { def is: String }
case object DBCScala extends DBCExecutionLanguage { val is = "scala" }
case object DBCPython extends DBCExecutionLanguage { val is = "python" }
case object DBCSQL extends DBCExecutionLanguage { val is = "sql" }