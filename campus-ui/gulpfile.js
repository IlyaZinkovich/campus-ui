var gulp = require('gulp'),
    $ = require('gulp-load-plugins')(),
    minifyCss = require('gulp-minify-css'),
    browserSync = require('browser-sync').create(),
    wiredep = require('wiredep').stream,
    modRewrite  = require('connect-modrewrite');

gulp.task('clean', function() {
  gulp.src('dist', {read:false})
    .pipe($.clean());
});

gulp.task('html', ['image'], function() {
  gulp.src('app/assets/**/*.html')
    .pipe(gulp.dest('dist/assets'))
    .pipe(browserSync.stream());
});

gulp.task("image", function() {
  return gulp.src("app/**/*.jpg")
    // .pipe($.imagemin())
    .pipe(gulp.dest("dist"));
});

gulp.task('build', function() {
  return gulp.src('app/*.html')
    .pipe($.useref())
    .pipe($.if('*.js', $.uglify()))
    .pipe($.if('*.css', minifyCss()))
    .pipe($.useref())
    .pipe(gulp.dest('dist'))
    .pipe(browserSync.stream());
});

gulp.task('bower', function() {
  return gulp.src('app/index.html')
    .pipe(wiredep({ directory: "app/bower_components"}))
    .pipe($.inject(gulp.src(['app/assets/**/*.js'], {read: false}), {ignorePath: 'app/', addRootSlash: false}))
    .pipe($.inject(gulp.src(['app/assets/**/*.css'], {read: false}), {ignorePath: 'app/', addRootSlash: false}))
    .pipe(gulp.dest("app"))
    .pipe(browserSync.stream());
});

gulp.task('default', ['build', 'html'], function () {
  browserSync.init({
    server: "./dist",
    port: 8083,
    notify: false,
    middleware: [
      modRewrite([
          '!\\.\\w+$ /index.html [L]'
      ])
    ],
    routes: {
        '/bower_components': '.app/bower_components'
    }
  });
  gulp.watch("app/**/*.{css,js, html}", ['build']);
  gulp.watch("app/**/*.html", ['html']);
});
