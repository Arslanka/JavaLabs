package commands;

import collection.Collection;
import data.Dragon;
import io.Printer;
import io.request.RequestDragon;

import static io.Console.SEPARATOR;
import static io.ConsoleColor.CYAN;
import static io.ConsoleColor.RED;

public class UpdateIdCommand implements Command {
    private final Collection collection;
    private final Printer printer;

    public UpdateIdCommand(Collection collection, Printer printer) {

        this.collection = collection;
        this.printer = printer;
    }

    @Override
    public boolean execute(Object... args) {
        try {
            collection.updateId(args[0], args[1]);
            printer.println("Элемент коллекции с id" + args[0] + " успешно обновлен", CYAN);
            printer.println(SEPARATOR, RED);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Вы не ввели элемент, который необходимо добавить в коллекцию." +
                    " Пожалуйста, попробуйте еще раз");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean withArgument() {
        return true;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "Обновляет значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public Class<?>[] getArgumentsClasses() {
        return new Class[]{Integer.class, Dragon.class};
    }
}
