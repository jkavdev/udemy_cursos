console.log(global === this)
console.log(module === this)
console.log(module.exports === this)

this.digaOi = () => console.log('Tá funcionandooooooooo, usando this nesta porra!')