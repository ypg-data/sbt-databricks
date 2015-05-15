package sbtdatabricks.util

sealed trait DBCCommandStatus { def status: String }
case object DBCCommandQueued extends DBCCommandStatus { def status = "Queued" }
case object DBCCommandRunning extends DBCCommandStatus { def status = "Running" }
case object DBCCommandCancelling extends DBCCommandStatus { def status = "Cancelling" }
case object DBCCommandFinished extends DBCCommandStatus { def status = "Finished" }
case object DBCCommandCancelled extends DBCCommandStatus { def status = "Cancelled" }
case object DBCCommandError extends DBCCommandStatus { def status = "Error" }
