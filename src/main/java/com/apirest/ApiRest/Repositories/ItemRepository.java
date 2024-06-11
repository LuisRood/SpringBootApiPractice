public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNombreContaining(String nombre);
}
