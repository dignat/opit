package dashboard



class CleanupJob {
    static triggers = {
      cron cronExpression: '0 0 * * 1,4 ?' 
    }

    def execute() {

        def cutoff = new Date() - 30

        def todelete = VirtualMachineStats.findAllByTimestampLessThanEquals(cutoff)

        //todelete.deleteAll()
    }
}
