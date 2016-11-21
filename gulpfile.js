var gulp = require('gulp'),
    $ = require('gulp-load-plugins')(),
    minifyCss = require('gulp-minify-css'),
    browserSync = require('browser-sync').create(),
    modRewrite  = require('connect-modrewrite');

gulp.task('clean', function() {
  gulp.src('dist/', {read:false})
    .pipe($.clean());
});

gulp.task('html', ['image', 'fonts'], function() {
  gulp.src('app/assets/**/*.html')
    .pipe(gulp.dest('dist/assets'))
    .pipe(browserSync.stream());
});

gulp.task('image', function() {
  return gulp.src('app/**/*.{jpg,svg}')
    // .pipe($.imagemin())
    .pipe(gulp.dest('dist'));
});

gulp.task('fonts', function() {
  return gulp.src(['node_modules/bootstrap/dist/fonts/glyphicons-halflings-regular.*'])
    .pipe(gulp.dest('dist/fonts'));
});

gulp.task('build', function() {
  return gulp.src('app/*.html')
    .pipe($.useref())
    // .pipe($.if('*.js', $.uglify()))
    .pipe($.if('*.css', minifyCss()))
    .pipe($.useref())
    .pipe(gulp.dest('dist'))
    .pipe(browserSync.stream());
});

gulp.task('bower', function() {
  return gulp.src('app/index.html')
    .pipe($.inject(gulp.src(['node_modules/*/*.min.js', 'app/assets/app.js','app/assets/parts/**/*.js', 'app/assets/services/**/*.js'], {read: false}), {ignorePath : 'app/', addRootSlash: false, relative: true}))
    .pipe($.inject(gulp.src(['app/assets/**/*.css'], {read: false}), {ignorePath : 'app/', addRootSlash: false}))
    .pipe(gulp.dest('app'))
    .pipe(browserSync.stream());
});

gulp.task('default', ['bower', 'build', 'html'], function () {
  browserSync.init({
    server: 'dist',
    port: 8083,
    notify: false,
    middleware: [
      modRewrite([
          '!\\.\\w+$ /index.html [L]'
      ])
    ],
    routes: {
        './node_modules': '.node_modules'
    }
  });
  gulp.watch('app/assets/**/*.{css,js, html}', ['build']);
  gulp.watch('app/assets/**/*.html', ['html']);
});
