obj = main.o
target = main_jack_bb_utils_contains 

INCLUDE=include

all: $(obj)
	${CC} ${CFLAGS} $(obj) -o $(target)

%.o:%.c
	${CC} ${CFLAGS} -c $^ -o $@

.PHONY: clean
clean:
	rm -rf $(obj) $(target)
