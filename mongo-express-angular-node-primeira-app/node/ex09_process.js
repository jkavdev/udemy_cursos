process.stdout.write('Usando entrada do angular!  ')

process.stdin.on('data', function(data){
    process.stdout.write(`O que vc pensou, troucha ${data.toString()}`)
    process.exit()
})