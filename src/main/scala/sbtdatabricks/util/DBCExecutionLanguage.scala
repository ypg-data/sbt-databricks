package sbtdatabricks

private[sbtdatabricks] sealed trait DBCExecutionLanguage { def is: String }
private[sbtdatabricks] case object DBCScala extends DBCExecutionLanguage { val is = "scala" }
private[sbtdatabricks] case object DBCPython extends DBCExecutionLanguage { val is = "python" }
private[sbtdatabricks] case object DBCSQL extends DBCExecutionLanguage { val is = "sql" }
