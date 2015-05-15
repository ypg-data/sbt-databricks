package sbtdatabricks.util

sealed trait DBCExecutionLanguage { def is: String }
case object DBCScala extends DBCExecutionLanguage { def is = "scala" }
case object DBCPython extends DBCExecutionLanguage { def is = "python" }
case object DBCSQL extends DBCExecutionLanguage { def is = "sql" }