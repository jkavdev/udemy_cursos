console.log(process.argv)

function temParam(param) {
    return process.argv.indexOf(param) !== -1
}

if (temParam('--producao')) {
    console.log('Fullllll Atention bitchs')
} else {
    console.log('Nao tem')
}