const BillingCycle = require("./billingCycle")

BillingCycle.methods(['get', 'post', 'put', 'delete'])
BillingCycle.updateOptions({new: true, runValidations: true})

module.exports = BillingCycle