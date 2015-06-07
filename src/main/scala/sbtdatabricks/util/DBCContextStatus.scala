package sbtdatabricks

private[sbtdatabricks] sealed trait DBCContextStatus { def status: String }
private[sbtdatabricks] case object DBCContextRunning extends DBCContextStatus { val status = "Running" }
private[sbtdatabricks] case object DBCContextPending extends DBCContextStatus { val status = "Pending" }
private[sbtdatabricks] case object DBCContextError extends DBCContextStatus { val status = "Error" }
