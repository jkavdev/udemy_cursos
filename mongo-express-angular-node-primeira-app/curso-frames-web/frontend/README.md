# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Gulp

* configurando as `tasks` da aplicacao

    gulp.task('app', ['app.html', 'app.css', 'app.js', 'app.assets'])

* configurando as `tasks` das dependencias

    gulp.task('deps', ['deps.css', 'deps.js', 'deps.fonts'])

* configurando as `tasks` das servidor

    glp.task('watch', () => { })
    gulp.task('server', ['watch'], () => { })

* juntando todas as tasks
* sabera qual ambiente a ser rodado `require('gulp-util')`
* rodara as task em sequencia `require('run-sequence')`
* indica os passos para producao `sequence('deps', 'app')`
* indica os passos para desenvolvimento `sequence('deps', 'app', 'server')`

    const util = require('gulp-util')
    const sequence = require('run-sequence')
    gulp.task('default', () => {
        if (util.env.production) {
            sequence('deps', 'app')
        } else {
            sequence('deps', 'app', 'server')
        }
    })

# Configurando as dependencias

* indicando os dependencias a serem importadas `return gulp.src([ '...' ])`
* reduzira o arquivo ao minimo possivel `.pipe(uglify())`
* produzira um arquivo final `js` `.pipe(concat('deps.min.js'))`
* indica o destino final do arquivo `.pipe(gulp.dest('public/assets/js'))`

    return gulp.src([
        '...'
    ])
        .pipe(uglify())
        .pipe(concat('deps.min.js'))
        .pipe(gulp.dest('public/assets/js'))    

* nao retirara os comentarios 

    .pipe(uglifycss({ "uglyComments": true }))        