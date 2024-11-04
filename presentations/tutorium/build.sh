DIAGRAMS=(java-compile)
SLIDES=(Introduction)
for p in $DIAGRAMS; do ./pikchr --svg-only $p.pikchr > $p.svg; done
for s in $SLIDES; do bundle exec asciidoctor-revealjs $s; done
