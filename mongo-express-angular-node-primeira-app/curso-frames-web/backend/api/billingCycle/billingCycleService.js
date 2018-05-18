const BillingCycle = require("./billingCycle")

BillingCycle.methods(['get', 'post', 'put', 'delete'])
BillingCycle.updateOptions({ new: true, runValidations: true })

BillingCycle.route('count', function (req, res, next) {
    BillingCycle.count(function (error, value) {
        if (error) {
            res.status(500).json({ errors: [error] })
        } else {
            res.json({ value })
        }
    })
})

module.exports = BillingCycle